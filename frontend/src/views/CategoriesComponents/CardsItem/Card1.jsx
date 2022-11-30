import { Card, Dropdown } from "flowbite-react";
import DogFood from "../../../assets/dog-food.jpg";

const Card1 = ({ description, image }) => {
  return (
    <div className="flex flex-col items-center">
      <div className="max-w-sm">
        <Card imgSrc={image}>
          <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
            {description}
          </h5>
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
