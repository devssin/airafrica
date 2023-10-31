<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/27/2023
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/WEB-INF/Header.jsp"%>


<div class=" py-16 bg-gray-100 min-h-screen">
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
        <h2 class="text-center text-2xl font-semibold text-gray-700 mb-2">Add Vol</h2>

        <form action="" method="post">
            <div class="grid grid-cols-2 gap-3">
                <div class="">
                    <label  class="text-sm text-gray-600 block ">Date Starts</label>
                    <input type="datetime-local" name="date_starts"  class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
                </div>
                <div class="">
                    <label class="text-sm text-gray-600 block ">Date Arrives</label>
                    <input type="datetime-local" name="date_arrives"  class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
                </div>

            </div>
            <div class="pt-4 grid grid-cols-2 gap-3">
                <div class="">
                    <label  class="text-sm text-gray-600 block ">Start City</label>
                    <input type="text" name="start_city"  class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
                </div>
                <div class="">
                    <label class="text-sm text-gray-600 block ">Arrive City</label>
                    <input type="text" name="arrive_city"  class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
                </div>
            </div>
            <div class="pt-4 grid grid-cols-2 gap-3">
                <div>
                    <label class="text-sm text-gray-600 block ">Plane</label>

                    <select name="plan_id" class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0 px-4 py-2">
                        <option value="0"> __Select Plan___</option>
                        <c:forEach var="plan" items="${plans}">
                            <option value="${plan.id}">${plan.name} (${plan.company.name})</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="">
                    <label class="text-sm text-gray-600 block ">Price</label>
                    <input type="text" name="price"  class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
                </div>

            </div>
            <div class="pt-4">
                <button type="input" class="block w-full text-center bg-primary py-2 text-white  hover:bg-sec   transition duration-300  rounded"> Add Flight</button>
            </div>
        </form>
    </div>
</div>

<%@include file="/WEB-INF/Footer.jsp"%>
