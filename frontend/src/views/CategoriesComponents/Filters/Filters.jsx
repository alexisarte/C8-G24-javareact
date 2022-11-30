
import Card from '../CardsItem/Card1'
import { Breadcrumb } from "flowbite-react";
import { useParams } from "react-router-dom";
import DogFood from "../../assets/dog-food.jpg";
import DogFood2 from "../../assets/excellent-dog-adulto-formula.jpg";

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
        <Card
          image={DogFood}
          description="Purina PRO PLAN por 10Kg $6000. Envío $ 500 en Tienda-Mía *precio
            mínimo garantizado"
        />
        <Card
          image={DogFood2}
          description="Purina EXCELLENT por 10Kg $7500. Envío gratis en LolaVet 
  *precio mínimo garantizado"
        />
      </div>
    </div>
  );
};

export default Filters;
