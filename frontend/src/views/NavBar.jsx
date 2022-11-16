import React from 'react';
import ButtonDropdown from './DropdownButton';

function NavBar() {
  return (
    <>
      <nav>
        <div className="">
          <div className="flex flex-row justify-around bg-teal-200 p-5">
            <ButtonDropdown title="Perros" />
            <ButtonDropdown title="Gatos" />
            <ButtonDropdown title="Promociones" />
            <ButtonDropdown title="Servicios" />
          </div>
        </div>
      </nav>
    </>
  );
}

export default NavBar;
