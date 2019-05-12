package com.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Autowired
	private TimeTableService tableService;

	@RequestMapping("/index")
	public ModelAndView index() {
		if (tableService.checkEmpty()) {
			tableService.simulateData(10);
		}
		List<TimeTable> tables = tableService.getAllTimeTables();
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("tables", tables);
		// System.out.println(tables);
		return model;
	}

	@RequestMapping("/latest")
	public ModelAndView latest() {
		TimeTable table = tableService.getLatestValue();
		ModelAndView model = new ModelAndView();
		model.addObject("table", table);
		model.setViewName("latest");
		return model;
	}

	@RequestMapping(value = "/simulate", method = RequestMethod.POST)
	public ModelAndView simulate(@RequestParam int records) {
		// System.out.println(records);
		tableService.deleteAll();
		tableService.simulateData(records);
		return index();
	}

	@RequestMapping("/simulate")
	public String simulateData() {
		return "simulate";
	}

	@RequestMapping("/average")
	public String averageForm() {
		return "average";
	}

	@RequestMapping(value = "/average", method = RequestMethod.POST)
	public ModelAndView average(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime time1,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime time2) {
		Timestamp t1 = Timestamp.valueOf(time1);
		Timestamp t2 = Timestamp.valueOf(time2);
		List<TimeTable> tables = tableService.getBetweenDates(t1, t2);
		Float averageVal = (float) tables.stream().mapToDouble(val -> val.getValue()).average().orElse(0.0);
		ModelAndView model = new ModelAndView();
		model.addObject("averageVal", averageVal);
		model.addObject("tables", tables);
		model.setViewName("average");
		return model;
	}

	@RequestMapping("/goodValues")
	public String goodValuesForm() {
		return "goodValues";
	}

	@RequestMapping(value = "/goodValues", method = RequestMethod.POST)
	public ModelAndView goodValues(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime time1,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime time2) {
		Timestamp t1 = Timestamp.valueOf(time1);
		Timestamp t2 = Timestamp.valueOf(time2);
		List<TimeTable> tables = tableService.getGoodValues(t1, t2);
		ModelAndView model = new ModelAndView();
		model.addObject("tables", tables);
		model.setViewName("goodValues");
		return model;
	}

	@RequestMapping("/interpolated")
	public String interpolatedForm() {
		return "interpolated";
	}

	@RequestMapping(value = "/interpolated", method = RequestMethod.POST)
	public ModelAndView interpolated(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime time1,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime time2,
			@RequestParam int minutes) {
		Timestamp t1 = Timestamp.valueOf(time1);
		Timestamp t2 = Timestamp.valueOf(time2);
		List<Map<Timestamp, Float>> data = tableService.getInterpolatedSeries(t1, t2, minutes);
		ModelAndView model = new ModelAndView();
		model.addObject("data", data);
		model.setViewName("interpolated");
		return model;
	}

}
