const Services = () => {
  return (
    <section className=" font-new">
      <p className="uppercase text-blue-600 p-4">en <span className="text-yellow-400">kai pet</span> te contactamos con los mejores centros veterinarios, cercanos a tu domicilio.</p>
      <div className="flex h-96  bg-blue-400">
        <ul className="flex flex-col justify-between w-3/4 list-inside list-disc uppercase p-6">
          <li>consulta de veterinaria</li>
          <li>procedimientos quirúrjicos</li>
          <li>urgencias y asistencia médica</li>
        </ul>
        <img className="w-1/4" src="../src/assets/veterinaria.png" alt="veterinaria" />
      </div>
    </section>
  );
};

export default Services;
