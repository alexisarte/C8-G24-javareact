import { Card } from "flowbite-react";
import Button from "./Button1";
import products from "../records/ProductsLists/ProductLists.json";
import { useParams } from "react-router-dom";
import { useContext, useState } from "react";
import CartContext from "../CartContext";

function Product() {
  const { id } = useParams();
  const indexProduct = products.findIndex(
    (p) => p.id === parseInt(id.slice(1), 10)
  );
  const [product, setProduct] = useState(products[indexProduct]);
  const [cantidad, setCantidad] = useState(1);
  const { cart, setCart } = useContext(CartContext);

  const addToCart = () => {
    setCart([...cart, product]);
  };

  const handleChange = (e) => {
    if (e.target.value > 1) {
      setCantidad(e.target.value);
      let cart2 = cart;
      cart2[indexProduct].cantidad = e.target.value;
      setCart(cart2);
    }
    console.log(e.target.value);
  };

  return (
    <div className="flex justify-around bg-[#F5F5F5] p-5">
      <img src={product.img} alt="" className="w-1/3" />
      <div className="text-center m-5 w-1/3 flex flex-col items-center">
        <header className="bg-[#F8CF32] p-5 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
          <h1>{product.product}</h1>
        </header>
        <div className="flex flex-col items-center mt-5 w-3/4">
          <Card href="#">
            <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              {product.product}
            </h5>
            <ul>
              <li>{`precio: $${product.precio}`}</li>
              <li>
                stock:{" "}
                <span className="text-[#0E9A2D] font-bold">
                  {`${product.stock} unidades`}
                </span>
              </li>
              <li>
                cantidad:{" "}
                <select
                  className="bg-[#D9D9D9]"
                >
                  {[...Array(product.stock).keys()].map((i) => (
                    <option key={i} value={i + 1}>
                      {i + 1}
                    </option>
                  ))}
                </select>
              </li>
            </ul>
          </Card>
          <div className="mt-5">
            <button onClick={() => addToCart()}>
              <Button tittle={"Agregar al carrito"} />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Product;
