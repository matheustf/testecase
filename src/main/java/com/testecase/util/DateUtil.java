package com.testecase.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	public LocalDateTime zerarMinSecNan(LocalDateTime data) {
		return data.withMinute(0).withSecond(0).withNano(0);

	}
}
