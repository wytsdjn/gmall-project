package com.shop.gmall.manage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

	@Test
	public void contextLoads() {

//		abstract class PizzaBuilder {
//			protected Pizza pizza;
//
//			public Pizza getPizza(){
//				return pizza;
//			}
//
//			public void createNewPizza() {
//				pizza = new Pizza();
//			}
//			//public (1)
//		}
//		class HawaiianPizzaBuilder extends PizzaBuilder {
//			public void buildParts() {
//				pizza.setParts("cross + mild +ham&pineapple");
//			}
//		}
//		class Waiter {
//			private PizzaBuilder pizzaBuilder; //hawaiian_PizzaBuilder
//			public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
//				//(2)
//			}
//			public Pizza getPizza(){
//				return pizzaBuilder.getPizza();
//			}
//			public void construct(){
//				pizzaBuilder.createNewPizza();
//				//(3)
//			}
//		}
//		class FastFoodOrdering{
//			public static void main(String[] args) {
//				Waiter waiter = new Waiter();
//				PizzaBuilder hawaiian_PizzaBuilder = new HawaiianPizzaBuilder();
//				//(4)
//				//(5)
//				System.out.println("pizza: "+waiter.getPizza());
//			}
//		}
////程序的输出结果为：Pizza:cross + mild + ham&pineapple
//
//		class Pizza {
//			private String parts;
//			public void setParts(String parts){
//				this.parts = parts;
//			}
//			public String toString(){
//				return this.parts;
//			}
//		}
	}

}
