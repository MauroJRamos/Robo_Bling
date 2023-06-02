import { Route, Switch } from 'react-router-dom';
import Navbar from './Navbar';
import Usuarios from './Usuarios';
import Produtos from './Produtos';
import './styles.css';
import Marcas from './Marcas';

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
        </Switch>
      </div>
    </div>
  );
};

export default Admin;