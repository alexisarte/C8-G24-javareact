import DropdownButton from './DropdownButton';

const petProducts = [
  'alimento concentrado',
  'humedo',
  'dietas naturales',
  'galletas-snacks',
  'antibioticos',
  'cuidado e higiene',
  'juguetes e interactivos',
];
const others = [
  'necesidades especiales',
  'adulto',
  'cachorro',
  'senior',
  'castrado/light',
];
const promotions = ['descuentos', 'especiales'];
const services = ['servicios de veterinaria a domicilio'];

const NavBar = () => {
  return (
    <nav className="flex justify-between p-3 sticky w-screen max-w-full md:p-0 md:static md:flex bg-teal-200 border-b-2 border-white">
      <div></div>
      <div className="menu hidden flex-col justify-center absolute top-0 left-0 w-1/2 h-screen z-10 -translate-x-1/4 transition ease-in-out duration-1000 bg-teal-300 pt-40 pl-7 md:bg-teal-200 md:static md:h-full md:flex md:flex-row md:justify-around md:w-full md:translate-x-0 md:p-0">
        <DropdownButton title="Perros" products={petProducts} path="/dogs" />
        <DropdownButton title="Gatos" products={petProducts} />
        <DropdownButton title="Otros" products={others} />
        <DropdownButton title="Promociones" products={promotions} />
        <DropdownButton title="Servicios" products={services} />
      </div>
      <div className="block md:hidden">
        <i
          className="fas fa-bars text-2xl"
          onClick={() => {
            const menu = document.querySelector('.fa-bars');
            menu.classList.toggle('hidden');
            const menuBars = document.querySelector('.fa-close');
            menuBars.classList.toggle('hidden');
            const nav = document.querySelector('.menu');
            nav.classList.toggle('hidden');
          }}
        ></i>
        <i
          className="fas fa-close hidden text-2xl"
          onClick={() => {
            const menu = document.querySelector('.fa-close');
            menu.classList.toggle('hidden');
            const menuBars = document.querySelector('.fa-bars');
            menuBars.classList.toggle('hidden');
            const nav = document.querySelector('.menu');
            nav.classList.toggle('hidden');
          }}
        ></i>
      </div>
    </nav>
  );
};

export default NavBar;
