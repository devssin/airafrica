<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/30/2023
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/Header.jsp" %>
<div class="py-16 bg-gray-100 min-h-screen">

    <div class="px-4 py-3 flex justify-center ">

        <a href="" class="text-center p-10">
            <h2 class="font-black text-xl">AIR<span class="font-poppins text-primary">AFRICA</span></h2>
        </a>

    </div>
    <div class="max-w-lg mx-auto">


        <h2 class="text-center text-2xl font-semibold text-gray-700 mb-2">Search Reasults</h2>

        <div class="grid grid-cols-1 gap-4">
            <c:forEach var="vol" items="${vols}">
                <div class="bg-white shadow-lg rounded-md w-full flex justify-between items-center p-4"
                >
                    <div>
                        <h4 class="text-blue-500">${vol.start_city} -> ${vol.arrive_city}</h4>
                        <p>Starts At : <span class="text-lg text-primary">${vol.starts_at}</span></p>
                        <p>Arrive At : <span class="text-lg text-primary">${vol.arrives_at}</span></p>
                        <p>Price : <span class="text-lg text-primary">${vol.price} DH</span></p>

                    </div>
                    <a href="" class="py-3 px-4 rounded-md bg-primary text-white text-lg hover:bg-red-800 transition transition-duration-100">
                        Make Reservation
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/Footer.jsp" %>
