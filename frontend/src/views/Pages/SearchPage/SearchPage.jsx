import { useContext } from "react";
import SearchContext from "../../Context/SearchContext/SearchContext";
import Card1 from "../../CategoriesComponents/CardsItem/Card1";


const SearchPage = () => {
  const { match } = useContext(SearchContext);

  if (match.length >= 1) {
    return (
      <>
        <div className="container mx-auto my-20">
          <div className="grid grid-cols-3 gap-y-8">
            {match.map((item) => {
              return (
                <>
                  <Card1 image={item.img} description={item.product} />
                </>
              );
            })}
          </div>
        </div>
      </>
    );
  } else {
    return (
      <>
        <div className="container mx-auto my-20">
          <p className="text-center">PRODUCTO NO ENCONTRADO</p>
        </div>
      </>
    );
  }
};

export default SearchPage;
