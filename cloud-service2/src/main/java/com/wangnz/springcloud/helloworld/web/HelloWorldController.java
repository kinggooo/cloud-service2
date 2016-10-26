package com.wangnz.springcloud.helloworld.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wangnz.springcloud.helloworld.model.User;

@RestController
public class HelloWorldController {

	volatile static int n = 0;
	volatile static int m = 0;

	Executor executor = Executors.newFixedThreadPool(10);

	// @ResponseBody
	// @RequestMapping(value = "/hello/{nPath}")
	// String home(@PathVariable(value = "nPath") int nPath) {
	//
	// final int sPath = nPath;
	//
	// Runnable task = new Runnable() {
	// @Override
	// public void run() {
	// System.out.println("hello当前线程："
	// + Thread.currentThread().getName());
	// System.out.println("hello请求数量：" + (sPath));
	// try {
	// Thread.sleep(500);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// System.out.println("hello处理完成：" + (sPath));
	// }
	// };
	// executor.execute(task);
	//
	// return "Hello World!" + n;
	// }

	@ResponseBody
	@RequestMapping(value = "/user")
	String user() {

		System.out.println("user当前线程：" + Thread.currentThread().getName());
		System.out.println("user请求数量：" + (++m));

		System.out.println("user处理完成：" + (m));
		return "Hello User!" + m;
	}

	@ResponseBody
	@RequestMapping(value = "/users")
	List<User> users() {
		List<User> ls = new ArrayList<User>();
		User user = new User();
		user.setUsername("helloworld users");
		ls.add(user);
		return ls;
	}
}
