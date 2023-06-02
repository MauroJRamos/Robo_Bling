import { ReactComponent as MainImage } from "assets/images/main-image.svg";
import ButtonIcon from "components/ButtonIcon";
import { Link } from 'react-router-dom';

import "./styles.css";

const Home = () => {
  return (
    <div className="home-container">
      <div className="base-card home-card">
        <div className="home-content-container">
          <div>
            <h1>Catálogo de produtos</h1>
            <p>
              Produtos que serão consultados no sistema Ancora e atualizados no Bling
            </p>
          </div>
          <div>
            <Link to="/produtos">
              <ButtonIcon text="Verificar o catalogo de produtos" />
            </Link>
          </div>
        </div>
        <div className="home-image-container">
          <MainImage />
        </div>
      </div>
    </div>
  );
};

export default Home;
