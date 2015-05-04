package com.advice;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

/**
 * @author user 
 * 用来监控service包方法耗时
 */
 /* 
 *  在“进入”连接点时，最高优先级的增强处理将最先被织入；在“退出”连接点时，最高优先级的增强处理会最后被织入。
 *  优先级高的切面类里的增强处理的优先级总是比优先级低的切面类中的增强处理的优先级高。 
 *  同一个切面类里的两个相同类型的增强处理在同一个连接点被织入时，Spring AOP将以随机的顺序来织入这两个增强处理，没有办法指定它们的织入顺序。
 *  如果确实需要保证它们以固有的顺序被织入，则可以考虑将多个增强处理压缩为一个增强处理；或者将不同增强处理重构到不同切面中，通过在切面级别上定义顺序。
 */
@Aspect
@Order(1)// 该属性值越小，优先级越高
public class AdviceMethodTakeTime {

	@Around(value = "execution(* com.service.*.* (..))")
	public Object methodTakeTimeAdvice(ProceedingJoinPoint point) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
		Object[] params = point.getArgs();
		String classmothed = point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName()+"("+StringUtils
		        .arrayToDelimitedString(params,",")+") ";
		Date startdt = new Date();
		System.out.print("==="+sdf.format(startdt));
		System.out.println("  准备执行方法："+classmothed+"。");
		Object returnValue = point.proceed(params);
		Date enddt = new Date();
		Long pendtime = ( enddt.getTime()-startdt.getTime() )/1000;
		System.out.print("==="+sdf.format(enddt));
		System.out.println(" "+classmothed+" 执行完毕。共耗时："+pendtime+"秒。");
		return returnValue;
     } 
}
