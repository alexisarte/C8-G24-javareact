import { Dropdown } from "flowbite-react";
import { Avatar } from "flowbite-react";
import user from "../../assets/vectors/user.svg";

const Account = () => {
  return (
    <>
      <Dropdown
        label={
          <>
            <Avatar
              alt="User settings"
              img={user}
              rounded={true}
              title="dsds"
            />
            <div>
              <p>HOLA</p>
            </div>{" "}
          </>
        }
        class=" hover:bg-yellow-200 rounded"
      >
        <Dropdown.Header>
          <span className="block text-sm">Bonnie Green</span>
          <span className="block text-sm font-medium truncate">
            bonnie@flowbite.com
          </span>
        </Dropdown.Header>
        <Dropdown.Item>Dashboard</Dropdown.Item>
        <Dropdown.Item>Settings</Dropdown.Item>
        <Dropdown.Item>Earnings</Dropdown.Item>
        <Dropdown.Divider />
        <Dropdown.Item>Sign out</Dropdown.Item>
      </Dropdown>
    </>
  );
};

export default Account;
