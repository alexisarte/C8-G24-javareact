import Card from "../CardsItem/Card1";
import { Breadcrumb } from "flowbite-react";
import { useParams } from "react-router-dom";

import products from "../../Records/ProductsLists/ProductLists.json";

const returned = (products.map((itemt) => itemt.comercios.find((itemer)=> itemer.precio)))



const Filters = ({ name }) => {
  const { product } = useParams();

  return (
    <div>
      <Breadcrumb aria-label="Default breadcrumb example">
        <Breadcrumb.Item exact href="/">
          Home
        </Breadcrumb.Item>
        <Breadcrumb.Item href="#">{name}</Breadcrumb.Item>
        <Breadcrumb.Item>{product.slice(1)}</Breadcrumb.Item>
      </Breadcrumb>
      <div className="flex flex-row ">
        <div className="w-60 bg-[#B4FFED] p-6">
          <h1>Filtros</h1>
          <h2>Marcas:</h2>
          <ul className="flex flex-col">
            <li className="p-2">Marca 1</li>
            <li className="p-2">Marca 2</li>
            <li className="p-2">Marca 3</li>
          </ul>
          <h2>Promociones:</h2>
          <ul className="flex flex-col">
            <li className="p-2">Promo 1</li>
            <li className="p-2">Promo 2</li>
            <li className="p-2">Promo 3</li>
          </ul>
        </div>
        <div className="grid grid-cols-3 gap-8 w-full">
          {products.map((item) => {
            return (
              <Card
                image={item.img}
                description={item.product}
                comercios={item.comercios}
              />
            );
          })}
        </div>
      </div>
    </div>
  );
};

export default Filters;
