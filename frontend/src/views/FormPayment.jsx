import { SpinnerCircularFixed } from "spinners-react";

const FormPayment = () => {
  return (
    <div className="flex flex-col bg-[#FFF6F6] text-center items-center">
        <div>
          <SpinnerCircularFixed
            size={300}
            thickness={100}
            speed={100}
            color="rgba(255, 204, 10, 1)"
            secondaryColor="rgba(0, 0, 0, 0.44)"
          />
        </div>
        <h1>Procesando Pago</h1>
        <ul>
          <li>Visa **** **** **** 1234</li>
          <li>Nombre: Juan Perez</li>
        </ul>
        <p>
          Alimento ProPlan x 10Kg a Lisandro de la Torre 39, Godoy Cruz-Mendoza.
          Total $7000
        </p>
    </div>
  );
};

export default FormPayment;
