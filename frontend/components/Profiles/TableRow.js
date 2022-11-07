const TableRow = (props) => {
    const { date, comment, authorType } = props;
  
        return (
          <tr>
            <th scope="row">{date}</th>
            <td>{comment}</td>
            <td>{authorType}</td>
          </tr>
        );
};

export default TableRow;

