<h1>¡API a seguir desarrollando!</h1>

<h3>Funcionamiento provisional.</h3>
<h2>USER</h2>


<p>Agregar item POST: "user/userId/add/itemId"</p>
<p>Quitar item POST: "user/userId/remove/itemId"</p>

<p>Obtener usuario por Id: GET "user/userId"</p>
<p>Ver carrito actual: GET "user/userId/cartResume"</p>
<p>Comparar items en mi ciudad GET "user/userId/itemNearMe/itemId"</p>
<p>
Alta de usuario: 2 pasos: 1- POST mediante Json "user/create" crea el usuario.
2- POST "user/addCartToUser/userId" Asigna un carrito al usuario.
</p>



<h2>SHOP</h2>
<p>
Agregar item POST: "shop/shopId/add/itemId"</p>
<p>Quitar item POST: "shop/shopId/remove/itemId"</p>

<p>Obtener shop por Id: GET "shop/shopId"</p>
<p>Filtrar items por categoria: GET "shop/shopId/filterBy/category
</p>

<h2>LOCATION</h2>

<p>Filtrar items por categoría y animal: GET "user/locationId/animal/category"
</p>
<p>Filtrar items por nombre: GET "user/locationId/itemName"
</p>
