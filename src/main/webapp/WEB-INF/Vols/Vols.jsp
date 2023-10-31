<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/28/2023
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/Header.jsp"%>
<div class="bg-gray-100 min-h-screen">
    <div class="flex justify-between items-center py-4 px-5">
        <h1>List of vols</h1>

        <a href="addVol" class="px-4 py-2 bg-primary text-white rounded-mg">
            Add Vol
        </a>
    </div>
    <div class="max-w-3xl mx-auto mt-10">
        <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
            <table class="w-full text-sm text-left text-gray-500 ">
                <thead class="text-xs text-gray-700 uppercase bg-gray-50  ">
                <tr>
                    <th scope="col" class="px-6 py-3">
                        Start
                    </th>
                    <th scope="col" class="px-6 py-3">
                        Arrive
                    </th>
                    <th scope="col" class="px-6 py-3">
                        Price
                    </th>
                    <th scope="col" class="px-6 py-3">
                        Escales
                    </th>
                    <th scope="col" class="px-6 py-3">
                        Actions
                    </th>
                </tr>
                </thead>
                <tbody class="earnings-container">
                <c:forEach var="vol" items="${vols}">
                    <tr class="bg-white border-b  hover:bg-gray-50">
                        <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap">
                                ${vol.start_city} ${vol.starts_at}
                        </th>
                        <td class="px-6 py-4">
                                ${vol.arrive_city} ${vol.arrives_at}
                        </td>
                        <td class="px-6 py-4">
                                ${vol.price} DH
                        </td>
                        <td>
                                ${vol.escales.size()}
                        </td>
                        <td>
                            <a href="addEscale?id=${vol.id}" class="p-3 bg-blue-400 text-white rounded-md">
                                Add escale
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/Footer.jsp"%>

