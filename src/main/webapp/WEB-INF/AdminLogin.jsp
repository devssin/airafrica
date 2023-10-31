<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/26/2023
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="Header.jsp"%>

<div class="containner py-16 bg-gray-100 min-h-screen">
    <a href="<?= URLROOT ?>/pages/index" class="absolute top-10 left-10 mb-10">
        <h2 class="text-lg font-bold text-gray-700"> <i class="fas fa-home ml-4 mr-2"></i> Go Home</h2>
    </a>
    <div class="max-w-lg mx-auto shadow-lg bg-white rounded-md px-6 py-4 overflow-hidden">
        <c:if test="${not empty message}">
            <div class="p-4 mb-4 text-sm text-red-800 rounded-lg bg-red-50" role="alert">
            <span class="font-medium">${message}</span>
            </div>
        </c:if>
        <a href="/" class="text-center p-10">
            <h2 class="font-black text-xl">AIR<span class="font-poppins text-primary">AFRICA</span></h2>
        </a>
        <h2 class="text-center text-2xl font-semibold text-gray-700 mb-2">Admin login</h2>

        <form action="" method="post">
            <div class="pt-4">
                <label for="email" class="text-sm text-gray-600 block ">Email Adress</label>
                <input type="text" name="username" placeholder="Email Adress" class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
            </div>
            <div class="pt-4">
                <%--@declare id="password"--%><label for="password" class="text-sm text-gray-600 block">Password</label>
                <input type="password" name="password" placeholder="Password" id="email" class="block w-full mt-1 text-sm text-gray-600  rounded-md focus:ring-0">
<%--                <span class="text-red-400 text-sm "><?= $data['password_err'] ?></span>--%>

            </div>
            <div class="pt-4">
                <button type="input" class="block w-full text-center bg-primary py-2 text-white  hover:bg-sec   transition duration-300  rounded"> Login</button>
            </div>
        </form>
    </div>
</div>
<%@include file="Footer.jsp"%>
