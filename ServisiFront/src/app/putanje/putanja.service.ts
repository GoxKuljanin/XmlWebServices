import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PutanjaService {

  private _app_url = 'https://localhost:8662/';
  private _authentication_url = 'https://localhost:8662/auth';
  //private _admin_url='https://localhost:8662/auth/'
  private _oglas_url='https://localhost:8662/oglas'
  private _oglas_service_url = this._app_url + 'oglas';
  private _zahtev_service_url = this._app_url + 'zahtev';
  private _search_service_url = this._app_url + 'search';
  private _komentar_service_url = this._app_url + 'komentar';
  private _vozilo_service_url = this._oglas_service_url + '/vozilo';
  private _termin_service_url = this._oglas_service_url + '/termin';

  constructor() { }

  private _login_url = this._authentication_url + '/login';
    get login_url(): string {
        return this._login_url;
    }
  
  private _user_info_url = this._app_url + 'user/getUserInfo'
    get userInfo(): string{
        return this._user_info_url;
    }

  private _novi_oglas_url=this._oglas_url+"vozilo/novoVozilo";
    get novoVozilo():string{
        return this._novi_oglas_url;
    }

    private _pravi_oglas_url=this._oglas_url+"/create";
    get noviOglas():string{
        return this._pravi_oglas_url;
    }

  //private _get_oglas_service_url = this._oglas_service_url + '/';
    get get_oglas_url(): string {
      return this._oglas_url;
    }
  
  private _send_zahtev_service_url = this._zahtev_service_url + '/zahtev';
    get get_zahtev_url(): string {
      return this._send_zahtev_service_url;
    }

    get get_vozilo_url(): string{
      return this._vozilo_service_url;
    }

    get get_termin_url(): string{
      return this._termin_service_url;
    }
    get get_search_url(): string{
      return this._search_service_url+'/search';
    }
    get get_komentar_url(): string{
      return this._komentar_service_url+'/komentar';
    }
}
