package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeTableRestController {

	@Autowired
	private TimeTableService tableService;

	@RequestMapping("/tables")
	public List<TimeTable> getAllTimeTables() {

		return tableService.getAllTimeTables();
	}

	@RequestMapping("tables/{id}")
	public TimeTable getTimeTable(@PathVariable int id) {
		return tableService.getTimeTable(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/tables")
	public void addTimeTable(@RequestBody TimeTable table) {
		tableService.addTimeTable(table);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/tables/{id}")
	public void addTimeTable(@RequestBody TimeTable table, @PathVariable int id) {
		tableService.updateTimeTable(id, table);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "tables/{id}")
	public void deleteTimeTable(@PathVariable int id) {
		tableService.deleteTimeTable(id);
	}

	@RequestMapping("tables/simulate/{n}")
	public List<TimeTable> simulateData1(@PathVariable int n) {
		tableService.simulateData(n);
		return tableService.getAllTimeTables();
	}

}
