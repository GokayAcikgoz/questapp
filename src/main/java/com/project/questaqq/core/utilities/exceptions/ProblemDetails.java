package com.project.questaqq.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//AOP İÇİN kullanıcıya çıkan hataları vermemek için.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
	String message;
}
