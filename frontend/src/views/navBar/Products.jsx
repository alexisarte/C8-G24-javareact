import { useParams } from "react-router-dom";
import Filters from "./Filters";

function Dogs() {
  const { product } = useParams();
  return (
    <div>
      <h1>Products</h1>
      <p>{product.slice(1)}</p>
      <Filters />
    </div>
  );
}

export default Dogs;
