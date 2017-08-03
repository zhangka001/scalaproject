package com.zrb.scalatest

import com.sun.glass.ui.MenuItem.Callback

/**
  * Created by Zhangrb on 2017/8/3.
  */
object scalatest {
  def main(args: Array[String]): Unit = {
    println("helloword")

    //anonymous function
    println(r())
//
//    val max1 = max(4,5)
//    println(max1)
    //参数，默认值
//    sayName("66666");
    //多参数
//    println(sumMoreParameters(1,3,45,6))

    //_的用法
    println(add2(3))
    //recurion
    println(fac(5))
    //柯里化
    println(m2(123))

    println(testfunction(r))

    testfunction2((a:Int,b:Int) => {println(a*b);a*b})
    testfunction2(add)
    println(add3(3,4,5))
    def sumf = sum(x => x*2)
    print(sumf(1,2))
  }

  def sum(f :Int => Int) : (Int ,Int) => Int = {
    def sumF(a : Int ,b : Int) : Int =
      if( a > b){
        0
      }else{
        println(f(a)+"----------")
        f(a) + sumF (a + 1, b)
      }

      sumF
  }

  //function的嵌套
  def add3(x:Int,y:Int,z:Int) : Int = {
    def add4(x:Int,y:Int) : Int = {
      x + y
    }
    add4(add4(x,y),z)
  }

  //将业务逻辑传入进来
  def testfunction2(callback : (Int,Int) => Int) ={
    println(callback(134,134))
  }

  //anonymous function
  var r = () => 333
  def testfunction(c : () => Int) {
    println(c())
  }

  def max(x: Int, y: Int): Int = {
    if(x > y){
      x
    }else{
      y
    }
  }
  //默认值
  def sayName(x : String = "dddd"): Unit ={
    println(x)
  }
  //多参数
  def sumMoreParameters(elem : Int*): Int ={
    var sum = 0
    for(e <- elem){
      println(e)
      sum += e
    }
    sum
  }
  def add(a : Int , b : Int) = a+b
  //_表明只传一个参数就行
  def add2 = add(_:Int,2)

  //递归
  def fac(n:Int):Int = if(n <= 0) 1 else n*fac(n-1)

  //函数柯里化
  //柯里化，把这个参数一个个独立开来写，这就是柯里化，
  def mulitply(x:Int)(y:Int) = x*y
  //柯里化在递归和控制抽象方面比较有用
  //柯里化就是把参数可以分开来，把部分函数传输可以用下划线来代替
  def m2 = mulitply(2)_




}
