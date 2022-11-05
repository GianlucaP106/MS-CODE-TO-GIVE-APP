// import { Chart as ChartJS, ArcElement, Tooltip, Legend, CategoryScale } from "chart.js";
import Chart from 'chart.js/auto';
import { Line } from "react-chartjs-2";

export default function LineChart(props){
    const { labels, values } = props;
    const data = {
        labels: labels,
        datasets: [{
          label: 'My First Dataset',
          data: values,
          fill: false,
          borderColor: 'rgb(75, 192, 192)',
          tension: 0.1
        }]
    };

    const test_data = {
        labels: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
        datasets: [{
            label: "Gained fruits",
            data: [0, 20, 42, 1, 34, 2, 2],
            fill: false,
            borderColor: 'rgb(75, 192, 192)', 
            tension: 0.1
        }]
    };

    return <Line data={test_data} ></Line>
}