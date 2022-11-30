
import Card from '../CardsItem/Card1'
import { Breadcrumb } from "flowbite-react";
import { useParams } from "react-router-dom";

const Filters = () => {
  const { product } = useParams();

  return (
    <div>
      <Breadcrumb aria-label="Default breadcrumb example">
        <Breadcrumb.Item exact href="/">
          Home
        </Breadcrumb.Item>
        <Breadcrumb.Item href="#">Dogs</Breadcrumb.Item>
        <Breadcrumb.Item>{product.slice(1)}</Breadcrumb.Item>
      </Breadcrumb>
      <div className="flex flex-row justify-between">
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
        <Card />
        <Card />
      </div>
    </div>
  );
};

export default Filters;
