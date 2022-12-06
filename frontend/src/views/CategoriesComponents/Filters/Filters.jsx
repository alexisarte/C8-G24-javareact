import Card from "../CardsItem/Card1";
import { Breadcrumb } from "flowbite-react";
import { useParams } from "react-router-dom";
import { useState } from "react";

import products from "../../Records/ProductsLists/ProductLists.json";

const returned = (products.map((itemt) => itemt.comercios.find((itemer)=> itemer.precio)))

const Filters = ({ name }) => {
  const { product } = useParams();
  const [filtersSelected, setFiltersSelected] = useState(
    products.map((accumulator, el) => ({ ...accumulator, [el.product]: false}), {})
  );
  const [filteredData, setFilteredData] = useState([]);


  const handleOnCheckbox = (e) => {
    setFiltersSelected({
      ...filtersSelected,
      [e.target.value]: e.target.checked
    });

    if (e.target.checked) {
      const result = products.filter((item) => item.product === e.target.value);
      setFilteredData([...filteredData, ...result]);
    } else {
      const result = filteredData.filter(
        (item) => item.product !== e.target.value
      );
      setFilteredData(result);
    }  
  };

  console.log(filteredData);

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
          <div className="flex flex-col">
            {products.map((item) => (
              <div className="flex flex-row">
                <input type="checkbox" value={item.product} onChange={handleOnCheckbox} />
                <label>{item.product}</label>
              </div>
            ))}
          </div>
          <h2>Promociones:</h2>
          <ul className="flex flex-col">
            {products.map((item) => (
              <li className="flex flex-row">
                <input type="checkbox" />
                <p>{item.cantidad}</p>
              </li>
            ))}
          </ul>
        </div>
        <div className="grid grid-cols-3 gap-8 w-full">
          {filteredData.map((item) => {
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
