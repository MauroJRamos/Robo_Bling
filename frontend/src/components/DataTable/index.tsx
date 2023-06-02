import axios from "axios";
import Pagination from "components/Pagination";
import ProdutoFiltro , { ProductFilterData } from "components/ProdutoFiltro";
import { useEffect, useState } from "react";
import { ProdutoPage } from "types/produto";
import { formatLocalDate, formatPrice } from "util/format";
import { BASE_URL } from "util/requests";


type ControlComponentsData = {
  activePage: number;
  filterData: ProductFilterData;
};


const DataTable = () => {
  const dataAtual = new Date();
  

  //const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<ProdutoPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  const [controlComponentsData, setControlComponentsData] =
    useState<ControlComponentsData>({
      activePage: 0,
      filterData: { codigo: '' },
    });

  const handleSubmitFilter = (data: ProductFilterData) => {
    setControlComponentsData({ activePage: 0, filterData: data });   
  };

  const handlePageChange = (pageNumber: number) => {
    setControlComponentsData({ activePage: pageNumber, filterData: controlComponentsData.filterData});
  };

  useEffect(() => {
    axios
      .get(
        `${BASE_URL}/produto?page=${controlComponentsData.activePage}&size=12&sort=nomProduto,desc&codigoId=${controlComponentsData.filterData.codigo}`
      )
      .then((response) => {
        setPage(response.data);
        
      });
  }, [ controlComponentsData]); //

  //const changePage = (index: number) => {
  // setActivePage(index);
 // };

  
  const handleStatusChange = (
    id: number, 
    status: string, 
    nomProduto:string,
    dscProduto:string,
    vlrPrecoAncora:number,
    datCadastro: string,
    codCna:string, 
    qtdEstoque:number, 
    vlrPrecoVenda:number, 
    codProduto:string
    ) => {
    axios
      .put(`${BASE_URL}/produto/${id}`,{
        "codProduto": codProduto,
        "nomProduto": nomProduto,
        "dscProduto": dscProduto,
        "vlrPrecoAncora": vlrPrecoAncora,
        "vlrAnoFabricacao": 0,
        "marcaId": 23.0,
        "codCna": codCna,
        "qtdEstoque": qtdEstoque,
        "vlrPrecoVenda": vlrPrecoVenda,
        "datCadastro": datCadastro,
        "datAtualizacao": dataAtual,
        "idtUsuarioCadastro": 1,
        "idtUsuarioAtualizacao": null,
        "ativoInativo": status
    }).then((response) => {
      // Recarregar a página do navegador
      window.location.reload();
    })
      .catch((error) => {
        // Tratar o erro, se houver
        console.log(error);
      });
  };

  return (
    <>
      <div className="product-crud-bar-container">
        <ProdutoFiltro onSubmitFilter={handleSubmitFilter}/>
      </div>
      
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="row">Nome Produto</th>
              <th scope="row">Desc Produto</th>
              <th scope="row">Valor Ancora</th>
              <th scope="row">Data Cadastro</th>
              <th scope="row">Codigo</th>
              <th scope="row">Estoque</th>
              <th scope="row">Valor Venda</th>
              <th scope="row">Data At.</th>
              <th scope="row">Status</th>
              <th></th> {/* Empty column for the button */}
            </tr>
          </thead>
          <tbody>
            {page.content?.map((item) => (
              <tr key={item.id}>
                <td>{item.nomProduto}</td>
                <td>{item.dscProduto}</td>
                <td>{formatPrice (item.vlrPrecoAncora)}</td>
                <td>{formatLocalDate(item.datCadastro, "dd/MM/yyyy")}</td>
                <td>{item.codProduto}</td>
                <td>{item.qtdEstoque}</td>
                <td>{formatPrice (item.vlrPrecoVenda)}</td>
                <td>{formatLocalDate(item.datAtualizacao, "dd/MM/yyyy")}</td>
                <td>{item.ativoInativo}</td>
                <td>
                  <button
                    onClick={() => handleStatusChange(item.id, item.ativoInativo === 'ATIVO' ? 'INATIVO' : 'ATIVO', 
                    item.nomProduto, item.dscProduto, item.vlrPrecoAncora, item.datCadastro,
                    item.codCna, item.qtdEstoque, item.vlrPrecoVenda, item.codProduto )}
                  >
                    {item.ativoInativo === 'ATIVO' ? 'Desativar' : 'Ativar'}
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <Pagination  forcePage={page?.number}
        pageCount={page ? page.totalPages : 0}
        range={3}
        onChange={handlePageChange} />
    </>
  );
};

export default DataTable;
