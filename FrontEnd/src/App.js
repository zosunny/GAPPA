import React, { useEffect } from 'react';
import './App.css';
import { Routes, Route } from "react-router-dom";

import LandingPage from './components/Auth/LandingPage';
import HomePage from './components/Home/HomePage';
import BorrowPage from './components/Loan/Borrow/BorrowPage';
import LendPage from './components/Loan/Lend/LendPage';
import HistoryPage from './components/Loan/History/HistoryPage';
import FriendsPage from './components/Friends/FriendsPage';
import ProfilePage from './components/Profile/ProfilePage';
import AccountDetail from './components/Home/AccountDetail';
import ProfileEditPage from './components/Profile/ProfileEditPage';
import MainAccountEditPage from './components/Profile/MainAccountEditPage';
import NoticePage from './components/Sidebar/NoticePage';
import QnAPage from './components/Sidebar/QnAPage';
import CustomerServicePage from './components/Sidebar/CustomerServicePage';


function App() {
  // vw, vh를 보이는 화면의 %로 계산하는 식
  function setScreenSize() {
    let vh = window.innerHeight * 0.01;
    document.documentElement.style.setProperty("--vh", `${vh}px`);
  }
  
  // useEffect로 실행될 때마다 작동 되게
  useEffect(() => {
    setScreenSize();
  }, [])

  const is_autication = false

  return (
    <div className="App">
      <Routes> {/*라우터 작동 정리*/}
        ({is_autication
          ?
          <Route path="/" element={<LandingPage />}/>
          :
          <>
            <Route path="/" element={<HomePage />}/>
            <Route path="/borrow" element={<BorrowPage />}/>
            <Route path="/lend" element={<LendPage />}/>
            <Route path="/history" element={<HistoryPage />}/>
            <Route path="/friends" element={<FriendsPage />}/>
            <Route path="/profile" element={<ProfilePage />}/>
            <Route path="/account" element={<AccountDetail />}/>
            <Route path="/profile/edit" element={<ProfileEditPage />}/>
            <Route path="/profile/accountedit" element={<MainAccountEditPage />}/>
            <Route path="/notice" element={<NoticePage />}/>
            <Route path="/qna" element={<QnAPage />}/>
            <Route path="/customersevice" element={<CustomerServicePage />}/>
          </>
        })
      </Routes>
    </div>
  );
}

export default App;