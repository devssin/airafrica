<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/30/2023
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
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
        <h2 class="text-center text-2xl font-semibold text-gray-700 mb-2">Add Escale for vol id : ${vol_id}</h2>

        <form action="addEscale" method="post">
                <input type="hidden" name="vol_id" value="${vol_id}">
                <div class="">
                    <label  class="text-sm text-gray-600 block ">Escale City</label>
                    <input type="text" name="escale_city"  class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
                </div>
                <div class="">
                    <label class="text-sm text-gray-600 block ">Duration (with hours)</label>
                    <input type="number" name="duration"  class="block w-full mt-1 text-sm  border  rounded-md  focus:ring-0" value="">
                </div>

            <div class="pt-4">
                <button type="input" class="block w-full text-center bg-primary py-2 text-white  hover:bg-sec   transition duration-300  rounded"> Add Flight</button>
            </div>
        </form>
    </div>
</div>

<%@include file="/WEB-INF/Footer.jsp"%>

