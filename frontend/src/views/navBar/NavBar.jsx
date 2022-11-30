import DropdownButton from "./DropdownButton";

const petProducts = [
  "alimento húmedo",
  "alimento seco",
  "alimento balanceado",
  "higiene",
  "snacks"
];
const others = ["dieta", "necesidades especiales"];
const promotions = ["juguetes", "accesorios", "cachorro", "adulto"];
const services = ["servicios veterinarios"];

const NavBar = () => {
  return (
    <nav
      className="capitalize flex justify-between p-3 static w-screen max-w-full md:p-0 md:static md:flex bg-teal-200 border-white"
      onClick={() => {
        const menu = document.querySelector(".bars");
        menu.classList.toggle("hidden");
        const menuBars = document.querySelector(".close");
        menuBars.classList.toggle("hidden");
        const nav = document.querySelector(".menu");
        nav.classList.toggle("hidden");
      }}
    >
      <div className="menu hidden flex-col justify-center absolute left-0 mt-9 md:m-0  w-1/2 h-screen z-10 bg-teal-600 pt-40 pl-7 md:bg-teal-200 md:static md:h-full md:flex md:flex-row md:justify-around md:w-full md:p-0">
        <DropdownButton title="perros" products={petProducts} path="/perros" />
        <DropdownButton title="gatos" products={petProducts} path="/gatos" />
        <DropdownButton title="otros" products={others} path="/otros" />
        <DropdownButton title="promociones" products={promotions} path="/promociones"/>
        <DropdownButton title="servicios" products={services} path="/servicios"/>
      </div>
      <div className="flex md:hidden ">
        <div className="bars">
          <i className="fas fa-bars text-2xl mr-2"></i>
        </div>
        <div className="close hidden">
          <i className="fas fa-close text-2xl  mr-2"></i>
        </div>
        opciones
      </div>
    </nav>
  );
};

export default NavBar;
