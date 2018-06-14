package net.logicsquad.recurring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class DifferenceTest {
	private TemporalExpression months = new RangeEveryYear(6, 9);
	private TemporalExpression days = new DayInMonth(2, -1);

	private TemporalExpression difference = Difference.of(months, days);

	private LocalDate in_1 = LocalDate.of(2018, 6, 1);
	private LocalDate in_2 = LocalDate.of(2018, 7, 1);
	private LocalDate in_3 = LocalDate.of(2018, 8, 1);
	private LocalDate in_4 = LocalDate.of(2018, 9, 1);
	private LocalDate in_5 = LocalDate.of(2018, 6, 27);
	private LocalDate in_6 = LocalDate.of(2018, 6, 25);

	private LocalDate out_1 = LocalDate.of(2018, 6, 26);
	private LocalDate out_2 = LocalDate.of(2018, 7, 31);
	private LocalDate out_3 = LocalDate.of(2018, 8, 28);
	private LocalDate out_4 = LocalDate.of(2018, 9, 25);

	@Test
	public void includesExpectedDays() {
		assertTrue(difference.includes(in_1));
		assertTrue(difference.includes(in_2));
		assertTrue(difference.includes(in_3));
		assertTrue(difference.includes(in_4));
		assertTrue(difference.includes(in_5));
		assertTrue(difference.includes(in_6));
		return;
	}

	@Test
	public void excludesExpectedDays() {
		assertFalse(difference.includes(out_1));
		assertFalse(difference.includes(out_2));
		assertFalse(difference.includes(out_3));
		assertFalse(difference.includes(out_4));
		return;
	}
}