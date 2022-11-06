import Head from "next/head";
import Image from "next/image";
import styles from "../styles/Home.module.css";
import Map from "../components/Map";
import Footer from "../components/Layout/Footer";
import ReactDOM from "react-dom/client";
import Search from "../components/Search";
import Drawer from "../components/Drawer";
import FarmerLeaderboard from "../components/Leaderboards/FarmerLeaderboard";
import ProfilePage from "../components/Profiles/ProfilePage";
import PrimarySearchAppBar from "../components/Layout/PrimarySearchAppBar";
import PageVisitsTable from "../components/Tables/PageVisitsTable";
import Hero from "../components/HomeSections/Hero";

export default function Home() {
  return (
    <div>
      <Head>
        <title>Title</title>
        <meta name="description" content="Generated by create next app" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main>
        <Search />
        {/* <Hero /> */}
        {/* <PrimarySearchAppBar/>
        <ProfilePage /> */}
      </main>
    </div>
  );
}
