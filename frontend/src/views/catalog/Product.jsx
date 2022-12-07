import { Card } from "flowbite-react";
import Button from "./Button1";
import products from "../records/ProductsLists/ProductLists.json";
import { useParams } from "react-router-dom";

import { useReducer } from "react";
import { TYPES } from "../actions/ShoppingAction";

function Product() {
  const [state, dispatch] = useReducer(shoppingReducer, shoppingInitialState);
  const { products, cart } = state;
  const { id } = useParams();

  const product = products.find((p) => p.id === parseInt(id.slice(1), 10));

  const addTocart = (id) => {
    dispatch({ type: TYPES.ADD_TO_CART, payload: id });
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
                <select className="bg-[#D9D9D9]">
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
            {/* <Button tittle={"Agregar al carrito"}/> */}
            <button onClick={() => addTocart(product.id)}>
              Agregar al carrito
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Product;
