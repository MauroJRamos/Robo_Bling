import { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { Usuario } from 'types/usuario';
import { SpringPage } from 'types/vendor/spring';
import { requestBackend } from 'util/requests';

const Usuarios = () => {
  const [page, setPage] = useState<SpringPage<Usuario>>();
 
  useEffect(() => {
    const params : AxiosRequestConfig = {
      url: '/usuario',
      params: {
        page: 0,
        size: 12,
      },
    };
 
    requestBackend(params).then((response) => {
      setPage(response.data);
    });
  }, []);
 
  return (
    <div>
      {page?.content.map((item) => (
        <p key={item.id}>{item.nom_usuario} {item.ativo_inativo}</p>
      ))}
    </div>
  );
};
  
  export default Usuarios;