import Filters from "../../CategoriesComponents/Filters/Filters";

function Products({ name }) {
  return (
    <div className="m-11">
      <h1>Products</h1>
      <Filters name={name}/>
    </div>
  );
}

export default Products;
