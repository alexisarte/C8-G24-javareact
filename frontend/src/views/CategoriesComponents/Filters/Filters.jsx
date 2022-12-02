import Card from "../CardsItem/Card1";
import { Breadcrumb } from "flowbite-react";
import { useParams } from "react-router-dom";
import { useEffect , useState } from "react";
import products from "../../Records/ProductsLists/ProductLists.json";




const Filters = () => {
  const { product } = useParams();
  const [ shopItem , setShopItem] = useState();
   
   const priceShop = products.map((shop) => shop.comercios);
   for (let i = 0; i < priceShop.length; i++) {
    const highPriceShop = (priceShop[i].sort((a , b ) => {
     return Number.parseInt(a.precio) - Number.parseInt(b.precio)
     }))
  
  }
   
   // }, []);

  return (
    <div>
      <Breadcrumb aria-label="Default breadcrumb example">
        <Breadcrumb.Item exact href="/">
          Home
        </Breadcrumb.Item>
        <Breadcrumb.Item href="#">Dogs</Breadcrumb.Item>
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
            console.log(item.comercios.map((item) => item.precio) )
            return (
              <Card
                image={item.img}
                description= {item.product}
                comercios={item.comercios}
                shopping ={item.comercios.map((item) => item.negocio)[0]}
                shipments ={item.comercios.map((item) => item.envio)[0]}
                price ={item.comercios.map((item) => item.precio)[0]}
              />
            );
          })}
        </div>
      </div>
    </div>
  );
};

export default Filters;
