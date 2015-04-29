package com.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class AdviceTest {

	// 匹配com.abc.service下的类中以before开始的方法

	@Before("execution(*  com.service.*.*Advice(..))")
	public void beforeAdvice1() {
		System.out.println("beforeAdvice1 begin");
		System.out.println("beforeAdvice1 end");
	}

	@AfterReturning(returning = "returnValue", pointcut = "execution(*  com.service.*.*Advice(..))")
	public void afterReturning23(Object returnValue) {
		System.out.println("afterReturning begin");
		System.out.println("returnValue："+returnValue);
		System.out.println("afterReturning end");
	}

	// @AfterThrowing(throwing = "exception", pointcut = "execution(*  com.service.*.throwing*(..))")
	// public void afterThrowing(Throwable exception) {
	// System.out.println("throwing："+exception);
	// System.out.println("afterThrowing");
	// }

	@After("execution(* com.service.*.toBeAdvice(..))")
	//After增强处理不管目标方法如何结束（正确还是异常），它都会被织入
	public void after2(JoinPoint point) {
		System.out.println("after begin");
		System.out.println("@After：目标方法为："+point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName());
		System.out.println("@After：参数为："+Arrays.toString(point.getArgs()));
		System.out.println("@After：被织入的目标对象为："+point.getTarget());
		System.out.println("after end");

	}
	
	@Around(value = "execution(* com.service.*.*Around(..))")
	public Object around33(ProceedingJoinPoint point) throws Throwable {
		System.out.println("around begin");
		// 修改目标方法的参数
		Object[] params = point.getArgs();
		if(params!=null){
			if(params.length>0&&params[0].getClass()==String.class){
				params[0] = "param111";
			}
			if(params.length>1&&params[1].getClass()==String.class){
				params[1] = "param222";
			}
		}

		// 执行目标方法，并保存目标方法执行后的返回值
		Object returnValue = point.proceed(params);
		System.out.println("around end");
		// 返回修改后的返回值
		return "方法实际返回值："+returnValue+"，这是返回值的后缀";
	}


}
