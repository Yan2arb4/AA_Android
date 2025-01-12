using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace AA_Backend.Models
{
    public class User : IdentityUser
    {
        [JsonIgnore]
        public virtual List<Character>? Characters { get; set; } = null!;
    }
}
