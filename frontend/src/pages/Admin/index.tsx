import { Route, Switch } from 'react-router-dom';
import Navbar from './Navbar';
import Usuarios from './Usuarios';
import Produtos from './Produtos';
import './styles.css';
import Marcas from './Marcas';
import Ancora from './DadosAncora';

const Admin = () => {
  return (
    <div className="admin-container">
      <Navbar />
      <div className="admin-content">
        <Switch>
          <Route path="/admin/produtos">
            <Produtos/>
          </Route>
          <Route path="/admin/marca">
            <Marcas/>
          </Route>
          <Route path="/admin/usuarios">
            <Usuarios/>
          </Route>
          <Route path="/admin/dados-ancora">
            <Ancora/>
          </Route>
          <Route path="/admin/posta-bling">
            <h1>Dados Bling</h1>
          </Route>
        </Switch>
      </div>
    </div>
  );
};

export default Admin;