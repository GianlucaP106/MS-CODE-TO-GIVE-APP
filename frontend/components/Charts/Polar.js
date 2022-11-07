import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie } from 'react-chartjs-2';
import { PolarArea } from 'react-chartjs-2';
import styles from '../../styles/components/Charts/Polar.module.css';

ChartJS.register(ArcElement, Tooltip, Legend);

export default function Polar(props) {
  const { className, labels, values } = props;
  const data = {
    labels: labels,
    datasets: [
      {
        label: 'Harvest Gleaned (kg)',
        data: values,
        backgroundColor: [
          'rgba(255, 99, 132, 0.5)',
          'rgba(54, 162, 235, 0.5)',
          'rgba(255, 206, 86, 0.5)',
          'rgba(75, 192, 192, 0.5)',
          'rgba(153, 102, 255, 0.5)',
        ],
        borderColor: [
          'rgba(255, 99, 132, 0.5)',
          'rgba(54, 162, 235, 0.5)',
          'rgba(255, 206, 86, 0.5)',
          'rgba(75, 192, 192, 0.5)',
          'rgba(153, 102, 255, 0.5)',
        ],
        borderWidth: 1,
      },
    ],
  };

  return <Pie data={data} className={className} />;
}
