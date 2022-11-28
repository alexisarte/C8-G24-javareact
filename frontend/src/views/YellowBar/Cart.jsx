
//Img or vector file
import cart from "../../assets/vectors/cart.svg";

//Components from flowbite
import { Dropdown, Avatar, Button } from "flowbite-react";

const productsInCart = [
  {
    id: 1,
    product: "Alimento Pro Plan 10 Kg adulto, raza mediana",
    precio: 6500,
    stock: 40,
    cantidad: 1,
    img: "https://flowbite.com/docs/images/people/profile-picture-1.jpg"
  },
  {
    id: 2,
    product: "Alimento Pro Plan 5 Kg adulto, raza Grande",
    precio: 2500,
    stock: 20,
    cantidad: 1,
    img: "https://flowbite.com/docs/images/people/profile-picture-2.jpg"
  },
  {
    id: 3,
    product: "Alimento Royal Canin 10 Kg adulto",
    precio: 4500,
    stock: 44,
    cantidad: 1,
    img: "https://flowbite.com/docs/images/people/profile-picture-3.jpg"
  },
  {
    id: 4,
    product: "Alimento Pro Plan 10 Kg adulto, raza mediana",
    precio: 8500,
    stock: 10,
    cantidad: 1,
    img: "https://flowbite.com/docs/images/people/profile-picture-4.jpg"
  },
  {
    id: 5,
    product: "Alimento Pro Plan 10 Kg adulto, raza pequeña",
    precio: 900,
    stock: 42,
    cantidad: 1,
    img: "https://flowbite.com/docs/images/people/profile-picture-5.jpg"
  }
];

const Cart = () => {
  function buyCart(){
    alert("Pasa a pagina de carrito")
  }

  return (
    <>
      <Dropdown
        label={
          <>
            <Avatar
              alt="cart"
              img={cart}
              rounded={true}
              class="w-max rounded p-4 hover:bg-yellow-200"
            />
          </>
        }
        class=" "
        arrowIcon={false}
        inline={true}
        placement="bottom-start"
      >
        <Dropdown.Header>
          <span className="block text-lg font-semibold truncate">Carrito</span>
          <span className="flex max-sm:hidden">
            <div className="sm:w-96 max-sm:w-36">
              <p>Productos</p>
            </div>
            <div className="flex items-center sm:w-28 ">
              <p>Cantidad</p>
            </div>
            <div className="inline-flex justify-end items-center text-base font-semibold text-gray-900 dark:text-white sm:w-28 max-sm:10">
              <p>Precio</p>
            </div>
          </span>
        </Dropdown.Header>
        <Dropdown.Item>
          <div className="flow-root">
            <ul className="divide-y divide-gray-200 dark:divide-gray-700">
              {productsInCart.map((products) => {
                return (
                  <>
                    <li className="py-3 sm:py-4" key={products.id}>
                      <div className="flex items-center space-x-4">
                        <div className="shrink-0">
                          <img
                            className="h-8 w-8 rounded"
                            src={products.img}
                            alt="Neil image"
                          />
                        </div>
                        <div className="sm:w-72 flex-1">
                          <p className="truncate text-sm font-medium text-gray-900 dark:text-white">
                            {products.product}
                          </p>
                          <p className="truncate text-sm text-gray-500 dark:text-gray-400">
                            {`${products.precio} + 500 de envío`}
                          </p>
                        </div>
                        <div className="flex flex-col items-center sm:w-28 ">
                          <p className="ml-5 mr-5">{products.cantidad}</p>
                        </div>
                        <div className="inline-flex justify-end items-center text-base font-semibold text-gray-900 dark:text-white sm:w-32">
                         $ {products.precio}
                        </div>
                      </div>
                    </li>
                  </>
                );
              })}
            </ul> 
          </div>
        </Dropdown.Item>
        <Dropdown.Divider/>
              <Dropdown.Item className="flex justify-between">
                  <p className="text-lg">Subtotal</p>
                  <p className="text-lg font-semibold">$ 6000</p>  
              </Dropdown.Item>
              <Dropdown.Item className="flex justify-center" required={true}>
                <Button onClick={buyCart} color="dark">Comprar</Button>
              </Dropdown.Item>
      </Dropdown>
    </>
  );
};

export default Cart;
