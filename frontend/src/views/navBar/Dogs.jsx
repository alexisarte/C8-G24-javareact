import {useParams} from 'react-router-dom';
import Filters from './Filters';

function Dogs() {
  const { product } = useParams();
  return (
    <div>
      <h1>Componente Dogs</h1>
      <p>{product}</p>
      <Filters />
    </div>
  )
}

export default Dogs;