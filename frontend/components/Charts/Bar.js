import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend,
  } from 'chart.js';
  import { Bar } from 'react-chartjs-2';

  
  ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend
  );
  

export default function BarChart(props) {
    const { className, labels, values } = props;
    const data = {
        
        labels: labels,
        datasets: [
            {
                label: 'Amount of crops saved (kg)',
                data: values,
                backgroundColor: [
                'rgba(54, 162, 235, 0.8)',
                ],
                borderColor: [
                    'rgba(54, 162, 235, 0.8)',
                ],
                borderWidth: 1,
            },
            ],
        };
        return <Bar data={data} className={className} />;
    }

  