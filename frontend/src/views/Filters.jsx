function Filters() {
  return (
    <div className="w-60 bg-blue-300">
      <h1>Filters</h1>
      <h2>Marcas:</h2>
      <ul className="flex flex-col">
        <li className="p-2">Marca 1</li>
        <li className="p-2">Marca 2</li>
        <li className="p-2">Marca 3</li>
      </ul>
      <h2>Promociones:</h2>
      <ul className="flex flex-col">
        <li className="p-2">Promo 1</li>
        <li className="p-2">Promo 2</li>
        <li className="p-2">Promo 3</li>
      </ul>
    </div>
  );
}

export default Filters;