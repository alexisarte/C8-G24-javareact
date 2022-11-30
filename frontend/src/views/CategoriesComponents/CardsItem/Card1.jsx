import { Card, Dropdown } from "flowbite-react";
import DogFood from "../../../assets/dog-food.jpg";

const Card1 = ({data}) => {
  return (
    <div className="flex flex-col items-center">
      <div className="max-w-sm">
        <Card imgSrc={DogFood }>
          <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
            Purina PRO PLAN por 10Kg $6000. Envío $ 500 en Tienda-Mía *precio
            mínimo garantizado
          </h5>
          {/* <p className="font-normal text-gray-700 dark:text-gray-400">
            Purina PRO PLAN por 10Kg $6000. Envío $ 500 en Tienda-Mía *precio
            mínimo garantizado
          </p> */}
        </Card>
      </div>
      <div className="m-4">
        <Dropdown label="Compáralo en X tiendas" placement="bottom">
          <Dropdown.Item>Tienda-Mía</Dropdown.Item>
          <Dropdown.Item>Settings</Dropdown.Item>
          <Dropdown.Item>Earnings</Dropdown.Item>
          <Dropdown.Item>Sign out</Dropdown.Item>
        </Dropdown>
      </div>
    </div>
  );
};

export default Card1;
