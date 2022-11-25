import hearth from '../../assets/vectors/hearth.svg'

//Components from flowbite
import { Dropdown , Avatar } from 'flowbite-react'


const Favourites = () =>{
    return(
        <>
        <>
      <Dropdown
      label={
        <>
          <Avatar
            alt="cart"
            img={hearth}
            rounded={true}
            class="w-max rounded p-4 hover:bg-yellow-200"
          />
        </>
      }
        class=""
        arrowIcon={false}
        inline={true}
        placement="bottom-end"

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
        </>
    )
}

export default Favourites