import { Card, Dropdown } from "flowbite-react";

const Card1 = ({ description, image, comercios , shopping , shipments , price }) => {

  return (
    <div className="flex flex-col items-center">
      <div className="max-w-sm">
        <Card imgSrc={image}>
          <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
            {description} 
          </h5>
          <h4 className="text-xl font-bold tracking-tight text-gray-900 dark:text-white">$ {price}</h4>
          <p>Envio ${shipments} en {shopping} </p>
        </Card>
      </div>
      <div className="m-4">
        <Dropdown label={`Compáralo en ${comercios.length} tiendas`} placement="bottom">
          {comercios.map((items) => {
            return (
              <Dropdown.Item className=" border w-96 flex justify-between border-r-0 border-l-0">
                <div>
                  <p>{items.negocio}</p>
                </div>
                <div>
                  <p>$ {items.precio}</p>
                  <p>$ {items.envio}</p>
                </div>
              </Dropdown.Item>
            );
          })}
        </Dropdown>
      </div>
     
    </div>
  );
};

export default Card1;
