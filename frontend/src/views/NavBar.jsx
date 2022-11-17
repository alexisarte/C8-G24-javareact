import ButtonDropdown from './DropdownButton';
const petProducts = ["alimento concentrado", "humedo", "dietas naturales", "galletas-snacks", "antibioticos", "cuidado e higiene", "juguetes e interactivos"];
const others = ['necesidades especiales', 'adulto', 'cachorro', 'senior', 'castrado/light'];
const promotions = ['descuentos', 'especiales'];
const services = ['servicios de veterinaria a domicilio'];

function NavBar() {
  return (
    <>
      <nav className="flex flex-row justify-around bg-teal-200">
        <ButtonDropdown title="Perros" products={petProducts}/>
        <ButtonDropdown title="Gatos" products={petProducts}/>
        <ButtonDropdown title="Otros" products={others}/>
        <ButtonDropdown title="Promociones" products={promotions}/>
        <ButtonDropdown title="Servicios" products={services}/>
      </nav>
    </>
  );
}

export default NavBar;
