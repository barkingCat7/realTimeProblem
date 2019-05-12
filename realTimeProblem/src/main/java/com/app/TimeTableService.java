package com.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.TimeTable.Qty;

@Service
public class TimeTableService {

	@Autowired
	private TimeTableRepository timeTableRepository;

	public List<TimeTable> getAllTimeTables() {
		List<TimeTable> list = new ArrayList<>();
		// list.add(new TimeTable(new Date(24637), 0.456f, "cm", Qty.GOOD));
		// list.add(new TimeTable(new Date(42637), 0.756f, "m", Qty.BAD));
		List<TimeTable> tables = new ArrayList<>();
		timeTableRepository.findAll().forEach(tables::add);
		return tables;
	}

	public TimeTable getTimeTable(int id) {
		return timeTableRepository.findById(id).get();

	}

	public void addTimeTable(TimeTable table) {
		timeTableRepository.save(table);
	}

	public void deleteAll() {
		timeTableRepository.deleteAll();
	}

	public Boolean checkEmpty() {
		if (timeTableRepository.count() > 0) {
			return false;
		} else
			return true;
	}

	public void simulateData(int n) {
		long offset = Timestamp.valueOf("1990-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2019-01-01 00:00:00").getTime();
		String[] units = { "cm", "m", "kg", "K", "J" };
		int rnd = new Random().nextInt(units.length);
		String unit = units[rnd];
		for (int i = 0; i < n; i++) {
			long diff = end - offset + 1;
			Timestamp randomDateTime = new Timestamp(offset + (long) (Math.random() * diff));
			Random rd = new Random();
			float randomValue = rd.nextFloat();
			Boolean b = rd.nextBoolean();
			Qty q;
			if (b) {
				q = Qty.GOOD;
			} else {
				q = Qty.BAD;
			}
			TimeTable table = new TimeTable(randomDateTime, randomValue, unit, q);
			timeTableRepository.save(table);
		}
	}

	public void updateTimeTable(int id, TimeTable table) {
		timeTableRepository.save(table);
	}

	public void deleteTimeTable(int id) {
		timeTableRepository.deleteById(id);
	}

	public TimeTable getLatestValue() {
		TimeTable table = timeTableRepository.findAllByOrderByDateTimeDesc().get(0);
		return table;
	}

	public List<TimeTable> getBetweenDates(Timestamp t1, Timestamp t2) {
		return timeTableRepository.findAllByDateTimeBetween(t1, t2);

	}

	public List<TimeTable> getGoodValues(Timestamp t1, Timestamp t2) {
		List<TimeTable> tables = timeTableRepository.findAllByDateTimeBetween(t1, t2);
		tables = tables.stream().filter(val -> val.getQuality().equals(Qty.GOOD)).collect(Collectors.toList());
		return tables;
	}

	public List<Map<Timestamp, Float>> getInterpolatedSeries(Timestamp t1, Timestamp t2, int minutes) {
		List<TimeTable> tables = timeTableRepository.findAllByDateTimeBetweenOrderByDateTimeAsc(t1, t2);
		if (!tables.isEmpty()) {
			long date1 = tables.get(0).getDateTime().getTime();
			long date2 = tables.get(tables.size() - 1).getDateTime().getTime();
			long dateX = date1;
			float val1 = tables.get(0).getValue();
			float val2 = tables.get(tables.size() - 1).getValue();
			long seriesSize = (Math.abs(date2 - date1) / 60000) / minutes;
			int size = Math.toIntExact(seriesSize);
			List<Map<Timestamp, Float>> myList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				dateX = dateX + minutes * 60000;
				if (dateX > date2)
					break;
				double tmp1 = date2 - date1;
				double tmp3 = dateX - date1;
				double tmp2 = val2 - val1;
				double valX = val1 + (tmp3) / tmp1 * Math.abs(tmp2);
				Map<Timestamp, Float> myMap = new HashMap<>();
				myMap.put(new Timestamp(dateX), (float) valX);
				myList.add(myMap);
			}
			return myList;
		}
		return null;
	}

}
