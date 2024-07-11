package com.freewiki.wikiapp;

import UnitTests.PageRankCalculatorTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WikiAppApplicationTests {

	@Test
	void contextLoads() {
		PageRankCalculatorTest rankCalculatorTest= new PageRankCalculatorTest();
		rankCalculatorTest.testCalculatePageRank();
	}

}
